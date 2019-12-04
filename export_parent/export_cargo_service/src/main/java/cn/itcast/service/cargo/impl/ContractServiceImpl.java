package cn.itcast.service.cargo.impl;

import cn.itcast.dao.cargo.ContractDao;
import cn.itcast.dao.cargo.ContractProductDao;
import cn.itcast.dao.cargo.ExtCproductDao;
import cn.itcast.domain.cargo.Contract;
import cn.itcast.domain.cargo.ContractExample;
import cn.itcast.service.cargo.ContractService;
import cn.itcast.vo.ContractProductVo;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractDao contractDao;
    @Autowired
    private ExtCproductDao extCproductDao;
    @Autowired
    private ContractProductDao contractProductDao;
    @Override
    public Contract findById(String id) {
        return contractDao.selectByPrimaryKey(id);
    }

    @Override
    public void save(Contract contract) {
        contractDao.insertSelective(contract);
    }

    @Override
    public void update(Contract contract) {
        contractDao.updateByPrimaryKeySelective(contract);
    }

    @Override
    public void delete(String id) {
//        删除附件 然后删除货物 最后删除合同
        extCproductDao.deleteByContractId(id);// delete from co_ext_cproduct where contract_id=?
        contractProductDao.deleteByContractId(id);// delete from co_contract_product where contract_id=?
        contractDao.deleteByPrimaryKey(id);
    }

    @Override
    public PageInfo findAll(ContractExample example, int page, int size) {
        PageHelper.startPage(page,size);
        List<Contract> list = contractDao.selectByExample(example);
        return new PageInfo(list,5);
    }

    @Override
    public List<ContractProductVo> findContractProductVoByShipTime(String shipTime,String companyId) {
        return contractDao.findContractProductVoByShipTime(shipTime,companyId);
    }
}
