package cn.itcast.controller.feedback;


import cn.itcast.domain.cargo.ShippingExample;
import cn.itcast.service.feedback.FeedbackService;
import cn.itcast.service.feedback.UserFeedbackService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import cn.itcast.controller.BaseController;
import cn.itcast.domain.feedback.Feedback;
import cn.itcast.domain.feedback.FeedbackExample;
import cn.itcast.domain.feedback.FeedbackExample.Criteria;
import cn.itcast.domain.system.User;

import cn.itcast.service.system.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping({"/system/userfeedback"})
public class UserFeedbackController extends BaseController {
    @Reference
    private UserFeedbackService userFeedbackService;
    @Autowired
    private UserService userService;

    public UserFeedbackController() {
    }

    @RequestMapping({"/list"})
    public String list(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "5") Integer size) {

//        ShippingExample shippingExample = new ShippingExample();
//        shippingExample.createCriteria().andCompanyIdEqualTo(getCompanyId());
//        shippingExample.setOrderByClause("create_time desc");
//        PageInfo pageInfo = shippingService.findAll(shippingExample, page, size);
//        // 将查询信息
//        request.setAttribute("page", pageInfo);
        FeedbackExample feedbackExample = new FeedbackExample();
        feedbackExample.createCriteria().andCompanyIdEqualTo(getCompanyId());
        PageInfo pageInfo= userFeedbackService.selectAll(feedbackExample, page, size);
        request.setAttribute("page", pageInfo);
        return "feedback/userfeedback/userfeedback-list";
    }

    @RequestMapping({"/toAdd"})
    public String toAdd() {
        return "feedback/userfeedback/userfeedback-add";
    }

    @RequestMapping({"/toUpdate"})
    public String toUpdate(String id, Model model) {
        model.addAttribute("feedback", this.userFeedbackService.selectFeedbackById(id));
        return "feedback/userfeedback/userfeedback-update";
    }

    @RequestMapping({"/toProcess"})
    public String toProcess(String id, Model model) {
        model.addAttribute("feedback", this.userFeedbackService.selectFeedbackById(id));
        return "feedback/userfeedback/handlefeedback-process";
    }

    @RequestMapping({"/toView"})
    public String toView(String id, Model model) {
        model.addAttribute("feedback", this.userFeedbackService.selectFeedbackById(id));
        return "feedback/userfeedback/userfeedback-view";
    }

    @RequestMapping({"/delete"})
    @ResponseBody
    public Integer delete(String id) {
        Feedback feedback = this.userFeedbackService.selectFeedbackById(id);
        if (feedback.getState() != 1 && feedback.getState() != 5 && feedback.getState() != 0) {
            if (feedback.getState() == 3) {
                this.userFeedbackService.deleteFeedback(id);
            }

            return null;
        } else {
            return feedback.getState();
        }
    }

    @RequestMapping({"/edit"})
    public String edit(Feedback feedback) {
        if (feedback != null) {
            if (StringUtils.isEmpty(feedback.getFeedbackId())) {
                addFeedback(feedback);
            } else {
                this.updateFeedback(feedback);
            }
        }

        return "redirect:/system/userfeedback/list.do";
    }

    private void addFeedback(Feedback feedback) {
        feedback.setFeedbackId(UUID.randomUUID().toString());
        feedback.setCompanyId(getCompanyId());
        feedback.setCompanyName(getCompanyName());
        feedback.setCreateDept(getUser().getCreateDept());
        feedback.setCreateBy(getUser().getCreateBy());
        feedback.setState(0);
        this.userFeedbackService.addFeedback(feedback);
    }

    private void updateFeedback(Feedback feedback) {
        feedback.setState(0);
        this.userFeedbackService.updateFeedback(feedback);
    }

    @RequestMapping(
            value = {"/submit"},
            name = "用户选中一条委托单,点击'提交'按钮"
    )
    @ResponseBody
    public Integer submit(String id) {
        Feedback feedback = this.userFeedbackService.selectFeedbackById(id);
        if (feedback.getState() != 1 && feedback.getState() != 2 && feedback.getState() != 3) {
            feedback.setState(1);
            this.userFeedbackService.updateFeedback(feedback);
            return null;
        } else {
            return feedback.getState();
        }
    }

    @RequestMapping(
            value = {"cancel"},
            name = "用户选中一条委托单,点击'提交'按钮"
    )
    @ResponseBody
    public Integer cancel(String id) {
        Feedback feedback = this.userFeedbackService.selectFeedbackById(id);
        if (feedback.getState() != 5 && feedback.getState() != 3) {
            if (feedback.getState() == 1) {
                feedback.setState(0);
            }

            if (feedback.getState() == 0) {
                feedback.setState(3);
            }

            this.userFeedbackService.updateFeedback(feedback);
            return null;
        } else {
            return feedback.getState();
        }
    }
}
