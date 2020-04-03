package lokman.in.sampleDemoAPp.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class RestEndPoints {
    @RequestMapping(value = "/course")
    public Course getEndpoints(
            @RequestParam(value="name", defaultValue="Spring boot", required = false) String name,
            @RequestParam(value="chapterCount", defaultValue="2", required = false) Integer chapterCount
            ){
        return new Course(name, chapterCount);
    }

    @PostMapping(value = "/course/save")
    public String saveCourse(@RequestBody Course course) throws Exception{
        return "Your course name is " + course.getName() + " with " + course.getChapterCount();
    }
}
