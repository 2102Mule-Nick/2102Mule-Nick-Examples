package org.openapitools.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-04-09T17:34:35.756-04:00[America/New_York]")
@Controller
@RequestMapping("${openapi.openAPIDefinition.base-path:}")
public class HelloApiController implements HelloApi {

    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public HelloApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}
