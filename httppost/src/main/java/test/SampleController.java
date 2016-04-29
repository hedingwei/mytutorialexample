package test;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
public class SampleController {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        String js = "function post(path, params, method) {\n" +
                "    method = method || \"post\"; // Set method to post by default if not specified.\n" +
                "\n" +
                "    // The rest of this code assumes you are not using a library.\n" +
                "    // It can be made less wordy if you use one.\n" +
                "    var form = document.createElement(\"form\");\n" +
                "    form.setAttribute(\"method\", method);\n" +
                "    form.setAttribute(\"action\", path);\n" +
                "\n" +
                "    for(var key in params) {\n" +
                "        if(params.hasOwnProperty(key)) {\n" +
                "            var hiddenField = document.createElement(\"input\");\n" +
                "            hiddenField.setAttribute(\"type\", \"hidden\");\n" +
                "            hiddenField.setAttribute(\"name\", key);\n" +
                "            hiddenField.setAttribute(\"value\", params[key]);\n" +
                "\n" +
                "            form.appendChild(hiddenField);\n" +
                "         }\n" +
                "    }\n" +
                "\n" +
                "    document.body.appendChild(form);\n" +
                "    form.submit();\n" +
                "}" +
                "post('http://cloud.kunteng.org/yunac/a/login', {username: 'admin',password: 'kunteng888'});"
                ;

        return "<html><body><script>"+js+"</script></body></html>";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }
}
