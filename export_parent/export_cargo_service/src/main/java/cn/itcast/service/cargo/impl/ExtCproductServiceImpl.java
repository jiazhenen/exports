package cn.itcast.service.cargo.impl;

import cn.itcast.dao.cargo.ContractDao;
import cn.itcast.dao.cargo.ExtCproductDao;
import cn.itcast.domain.cargo.Contract;
import cn.itcast.domain.cargo.ExtCproduct;
import cn.itcast.domain.cargo.ExtCproductExample;
import cn.itcast.service.cargo.ExtCproductService;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ExtCproductServiceImpl implements ExtCproductService {

    @Autowired
    private ExtCproductDao extCproductDao;
    @Autowired
    private ContractDao contractDao;

    @Override
    public void save(ExtCproduct extCproduct) {
//                1、计算小计金额  单价*数量
        double amount = extCproduct.getPrice() * extCproduct.getCnumber();
        extCproduct.setAmount(amount);

        String contractId = extCproduct.getContractId();
        Contract contract = contractDao.selectByPrimaryKey(contractId);
//                2、修改合同上的附件数量 +1
        contract.setExtNum(contract.getExtNum()+1);
//                3、修改合同书的总金额  +小计金额
        contract.setTotalAmount(contract.getTotalAmount()+amount);
        contractDao.updateByPrimaryKeySelective(contract);
        extCproductDao.insertSelective(extCproduct);
    }

    @Override
    public void update(ExtCproduct extCproduct) {
        ExtCproduct extCproduct_old = extCproductDao.selectByPrimaryKey(extCproduct.getId());
        Double amount_old = extCproduct_old.getAmount(); //获取修改之前的小计金额（旧的）

//        1、重新计算小计金额
        double amount_new = extCproduct.getPrice() * extCproduct.getCnumber();
        extCproduct.setAmount(amount_new);
//        2、修改合同书的总金额  原总金额-旧的小计金额+新的小计金额
        String contractId = extCproduct.getContractId();
        Contract contract = contractDao.selectByPrimaryKey(contractId);
        contract.setTotalAmount(contract.getTotalAmount()-amount_old+amount_new);
        contractDao.updateByPrimaryKeySelective(contract);

        extCproductDao.updateByPrimaryKeySelective(extCproduct);
    }

    @Override
    public void delete(String id) {//id附件的id
        ExtCproduct extCproduct = extCproductDao.selectByPrimaryKey(id);
        String contractId = extCproduct.getContractId();
        Contract contract = contractDao.selectByPrimaryKey(contractId);
//        1、修改合同上附件数量
        contract.setExtNum(contract.getExtNum()-1);
//        2、修改合同上总金额
        contract.setTotalAmount(contract.getTotalAmount()-extCproduct.getAmount());
        contractDao.updateByPrimaryKeySelective(contract);

        extCproductDao.deleteByPrimaryKey(id);
    }

    @Override
    public ExtCproduct findById(String id) {
        return extCproductDao.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo findAll(ExtCproductExample example, int page, int size) {
        PageHelper.startPage(page,size);
        List<ExtCproduct> list = extCproductDao.selectByExample(example);
        return new PageInfo(list);
    }
}
