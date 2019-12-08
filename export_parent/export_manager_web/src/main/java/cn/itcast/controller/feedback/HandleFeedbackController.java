package cn.itcast.controller.feedback;


import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import cn.itcast.controller.BaseController;
import cn.itcast.domain.feedback.Feedback;
import cn.itcast.domain.feedback.FeedbackExample;
import cn.itcast.domain.feedback.FeedbackExample.Criteria;
import cn.itcast.domain.system.User;
import cn.itcast.service.feedback.HandleFeedbackService;
import cn.itcast.service.system.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping({"/system/handlefeedback"})
public class HandleFeedbackController extends BaseController {
    @Reference
    private HandleFeedbackService handleFeedbackService;
    @Autowired
    private UserService userService;

    public HandleFeedbackController() {
    }

    @RequestMapping({"/list"})
    public String list(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "2") Integer pageSize, Model model) {
        User user = this.userService.findUserById(getUser().getCreateBy());
        Integer degree = 4;
        if (user != null) {
            degree = user.getDegree();
        }

        FeedbackExample example = new FeedbackExample();
        Criteria criteria = example.createCriteria();
        criteria.andCompanyIdEqualTo(getCompanyId()).andStateEqualTo("0");
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

        PageInfo<Feedback> pageNum = this.handleFeedbackService.selectAll(example, page, pageSize);
        model.addAttribute("page", pageNum);
        return "feedback/userfeedback/handlefeedback-list";
    }

    @RequestMapping({"/toAdd"})
    public String toAdd() {
        return "feedback/feedback-add";
    }

    @RequestMapping({"/toUpdate"})
    public String toUpdate(String id, Model model) {
        model.addAttribute("feedback", this.handleFeedbackService.selectFeedbackById(id));
        return "feedback/feedback-update";
    }

    @RequestMapping({"/toProcess"})
    public String toProcess(String id, Model model) {
        model.addAttribute("feedback", this.handleFeedbackService.selectFeedbackById(id));
        return "feedback/userfeedback/handlefeedback-process";
    }

    @RequestMapping({"/toView"})
    public String toView(String id, Model model) {
        model.addAttribute("feedback", this.handleFeedbackService.selectFeedbackById(id));
        return "feedback/feedback-view";
    }

    @RequestMapping({"/delete"})
    public String delete(String id) {
        this.handleFeedbackService.deleteFeedback(id);
        return "redirect:/system/feedback/list.do";
    }

    @RequestMapping({"/edit"})
    public String edit(Feedback feedback) {
        if (feedback != null) {
            if (StringUtils.isEmpty(feedback.getFeedbackId())) {
                this.addFeedback(feedback);
            } else {
                this.updateFeedback(feedback);
            }
        }

        return "redirect:/system/handlefeedback/list.do";
    }

    private void addFeedback(Feedback feedback) {
        feedback.setCompanyId(getCompanyId());
        feedback.setCompanyName(getCompanyName());
        feedback.setCreateDept(getUser().getCreateDept());
        feedback.setCreateBy(getUser().getCreateBy());
        this.handleFeedbackService.addFeedback(feedback);
    }

    private void updateFeedback(Feedback feedback) {
        this.handleFeedbackService.updateFeedback(feedback);
    }
}
