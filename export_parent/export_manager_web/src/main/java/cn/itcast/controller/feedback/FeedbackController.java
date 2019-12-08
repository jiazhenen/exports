package cn.itcast.controller.feedback;


import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import cn.itcast.controller.BaseController;
import cn.itcast.domain.feedback.Feedback;
import cn.itcast.domain.feedback.FeedbackExample;
import cn.itcast.domain.feedback.FeedbackExample.Criteria;
import cn.itcast.service.feedback.FeedbackService;
import cn.itcast.service.feedback.UserFeedbackService;
import cn.itcast.service.system.UserService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping({"/system/feedback"})
public class FeedbackController extends BaseController {
    @Reference
    private FeedbackService feedbackService;
    @Reference
    private UserFeedbackService userFeedbackService;
    @Autowired
    private UserService userService;

    public FeedbackController() {
    }

    @RequestMapping({"/list"})
    public String list(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "2") Integer pageSize, Model model) {
        FeedbackExample feedbackExample = new FeedbackExample();
        Criteria criteria1 = feedbackExample.createCriteria();
        List list = new ArrayList();
        list.add(1);
        list.add(5);
        criteria1.andStateIn(list);
        PageInfo pageInfo = this.userFeedbackService.selectAll(feedbackExample, page, pageSize);
        model.addAttribute("page", pageInfo);
        return "feedback/feedback-list";
    }

    @RequestMapping({"/toAdd"})
    public String toAdd() {
        return "feedback/feedback-add";
    }

    @RequestMapping({"/toUpdate"})
    public String toUpdate(String id, Model model) {
        model.addAttribute("feedback", this.userFeedbackService.selectFeedbackById(id));
        return "feedback/feedback-process";
    }

    @RequestMapping({"/toProcess"})
    public String toProcess(String id, Model model) {
        model.addAttribute("feedback", this.userFeedbackService.selectFeedbackById(id));
        return "feedback/feedback-process";
    }

    @RequestMapping({"/toView"})
    public String toView(String id, Model model) {
        model.addAttribute("feedback", this.userFeedbackService.selectFeedbackById(id));
        return "feedback/feedback-view";
    }

    @RequestMapping({"/delete"})
    public String delete(String id) {
        this.feedbackService.deleteFeedback(id);
        return "redirect:/system/feedback/list.do";
    }

    @RequestMapping({"/edit"})
    public String edit(Feedback feedback) {
        System.out.println("11");
        System.out.println(feedback);
        feedback.setState(5);
        System.out.println(feedback);
        this.userFeedbackService.update(feedback);
        return "redirect:/system/feedback/list.do";
    }

    private void addFeedback(Feedback feedback) {
        feedback.setCompanyId(getCompanyId());
        feedback.setCompanyName(getCompanyName());
        feedback.setCreateDept(getUser().getCreateDept());
        feedback.setCreateBy(getUser().getUserName());
        feedback.setState(5);
        this.userFeedbackService.updateFeedback(feedback);
    }
}
