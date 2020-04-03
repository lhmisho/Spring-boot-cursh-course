package lokman.in.sampleDemoAPp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class RestEndPoints {

    @Autowired
    CourseConfiguration courseConfiguration;

    @Value("${default.course.name}")
    private String cName;

    @Value("${default.course.chapterCount}")
    private Integer cCount;

    @RequestMapping(value = "/defaultValue")
    public Course getDefaultValue(
            @RequestParam(value="name", defaultValue="Spring boot", required = false) String name,
            @RequestParam(value="chapterCount", defaultValue="2", required = false) Integer chapterCount
    ){
        return new Course(cName, cCount);
    }


    @GetMapping("/getHirarchy")
    public HashMap<String, Object> getConfigurationProperties(
            @RequestParam(value="name", defaultValue="Spring boot", required = false) String name,
            @RequestParam(value="chapterCount", defaultValue="2", required = false) Integer chapterCount
    ){
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("name", courseConfiguration.getName());
        map.put("courseCount", courseConfiguration.getChapterCount());
        map.put("rating", courseConfiguration.getRating());
        map.put("author", courseConfiguration.getAuther());

        return map;
    }

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
