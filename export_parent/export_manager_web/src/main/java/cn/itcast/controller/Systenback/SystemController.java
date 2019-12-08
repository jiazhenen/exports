package cn.itcast.controller.Systenback;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import cn.itcast.controller.BaseController;
import cn.itcast.domain.system.User;
import cn.itcast.domain.systemback.Sassfeedback;
import cn.itcast.domain.systemback.SassfeedbackExample;
import cn.itcast.domain.systemback.Systemback;
import cn.itcast.domain.systemback.SystembackExample;
import cn.itcast.domain.systemback.SystembackExample.Criteria;
import cn.itcast.service.feedback.SassbackService;
import cn.itcast.service.feedback.SystembackService;
import cn.itcast.service.system.UserService;
import java.util.UUID;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping({"/system/systemback"})
public class SystemController extends BaseController {
    @Reference
    private SystembackService systembackService;
    @Reference
    private SassbackService sassbackService;
    @Autowired
    private UserService userService;

    public SystemController() {
    }

    @RequestMapping({"/list"})
    public String list(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "3") Integer pageSize, Model model) {
        User user = userService.findUserById(getUser().getCreateBy());
        Integer degree = 4;
        if (user != null) {
            degree = user.getDegree();
        }

        SystembackExample example = new SystembackExample();
        Criteria criteria = example.createCriteria();
        criteria.andCompanyIdEqualTo(getCompanyId());
        switch(degree) {
            case 2:
                criteria.andCreateDeptLike(getUser().getDeptName() + "%");
                break;
            case 3:
                criteria.andCreateDeptEqualTo(getUser().getDeptName());
                break;
            case 4:
                criteria.andCreateByEqualTo(getUser().getCreateBy());
        }

        PageInfo<Systemback> page = this.systembackService.selectAll(example, pageNum, pageSize);
        model.addAttribute("page", page);
        return "systemback/systemback-list";
    }

    @RequestMapping({"/toAdd"})
    public String toAdd() {
        return "systemback/systemback-add";
    }

    @RequestMapping({"/toUpdate"})
    public String toUpdate(String id, Model model) {
        model.addAttribute("Systemback", this.systembackService.selectSystembackById(id));
        return "systemback/systemback-update";
    }

    @RequestMapping({"/toProcess"})
    public String toProcess(String id) {
        Sassfeedback sassfeedback = this.sassbackService.selectSassfeedbackById(id);
        this.request.setAttribute("Sassfeedback", sassfeedback);
        return "systemback/systemback-process";
    }

    @RequestMapping({"/toView"})
    public String toView(String id, Model model) {
        model.addAttribute("Systemback", this.systembackService.selectSystembackById(id));
        return "systemback/systemback-view";
    }

    @RequestMapping({"/toViewsass"})
    public String toViewsass(String id) {
        Sassfeedback sassfeedback = this.sassbackService.selectSassfeedbackById(id);
        this.request.setAttribute("Sassfeedback", sassfeedback);
        return "systemback/systemback-sassview";
    }

    @RequestMapping({"/submit"})
    public String submit(String id) {
        Systemback systemback =systembackService.selectSystembackById(id);
        systemback.setUpdateState("1");
        systemback.setSolveMethod("还未处理,请耐心等候...");
        Sassfeedback sassfeedback = new Sassfeedback();
        sassfeedback.setSassfeedId(UUID.randomUUID().toString());
        BeanUtils.copyProperties(systemback, sassfeedback);
        sassfeedback.setSolveMethod((String)null);
        this.sassbackService.addSassfeedback(sassfeedback);
        this.systembackService.updateSystemback(systemback);
        return "redirect:/system/systemback/list.do";
    }

    @RequestMapping({"/delete"})
    public String delete(String id) {
        this.systembackService.deleteSystemback(id);
        return "redirect:/system/systemback/list.do";
    }

    @RequestMapping({"/edit"})
    public String edit(Systemback Systemback) {
        if (Systemback != null) {
            if (StringUtils.isEmpty(Systemback.getSystembackId())) {
                this.addSystemback(Systemback);
            } else {
                this.updateSystemback(Systemback);
            }
        }

        return "redirect:/system/systemback/list.do";
    }

    private void addSystemback(Systemback Systemback) {
        Systemback.setCompanyId(getCompanyId());
        Systemback.setCompanyName(getCompanyName());
        Systemback.setCreateDept(getUser().getCreateDept());
        Systemback.setCreateBy(getUser().getUserName());
        Systemback.setUpdateState("0");
        this.systembackService.addSystemback(Systemback);
    }

    private void updateSystemback(Systemback Systemback) {
        Systemback.setUpdateState("0");
        this.systembackService.updateSystemback(Systemback);
    }

    @RequestMapping({"/feedbacklist"})
    public String feedbacklist(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "3") Integer pageSize, Model model) {
        SassfeedbackExample sassfeedbackExample = new SassfeedbackExample();
        sassfeedbackExample.setOrderByClause("create_time desc");
        PageInfo<Sassfeedback> page = this.sassbackService.selectAll(sassfeedbackExample, pageNum, pageSize);
        model.addAttribute("page", page);
        return "systemback/systemback-processlist";
    }

    @RequestMapping({"/editprocess"})
    public String editprocess(Sassfeedback sassfeedback) {
        sassfeedback.setState("1");
        this.sassbackService.updateSassfeedback(sassfeedback);
        Sassfeedback sassfeednew = this.sassbackService.selectSassfeedbackById(sassfeedback.getSassfeedId());
        Systemback systemback = this.systembackService.selectSystembackById(sassfeednew.getSystembackId());
        if (systemback != null) {
            systemback.setSolveMethod(sassfeednew.getSolveMethod());
            systemback.setAnswerBy(sassfeednew.getAnswerBy());
            systemback.setAnswerTime(sassfeednew.getAnswerTime());
            systemback.setResolution(sassfeednew.getResolution());
            this.systembackService.updateSystemback(systemback);
        } else {
            Systemback systembacknew = new Systemback();
            BeanUtils.copyProperties(sassfeednew, systembacknew);
            this.systembackService.addSystemback(systembacknew);
        }

        return "redirect:/system/systemback/feedbacklist.do";
    }
}
