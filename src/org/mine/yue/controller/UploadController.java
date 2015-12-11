package org.mine.yue.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mine.yue.domain.AddItem;
import org.mine.yue.util.AnalysisXMLUtils;
import org.mine.yue.util.UploadUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadController {

	@RequestMapping("/upload")
	public ModelAndView upload(HttpServletRequest request){
		List<AddItem> lists = null;
		
		try {
			UploadUtils.upload(request);
		} catch (IllegalStateException | IOException e) {
			System.out.println("error~~");
			e.printStackTrace();
			
		}
		lists = AnalysisXMLUtils.AnalysisXML("");
		
		ModelAndView mv = new ModelAndView("succ");
		mv.addObject("lists", lists);
		
		
		return mv;
	}
}
