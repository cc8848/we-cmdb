package com.webank.cmdb.controller.ui;

import static com.webank.cmdb.domain.AdmMenu.MENU_ADMIN_QUERY_LOG;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webank.cmdb.dto.LogDto;
import com.webank.cmdb.dto.QueryHeader;
import com.webank.cmdb.dto.QueryRequest;
import com.webank.cmdb.dto.QueryResponse;
import com.webank.cmdb.service.LogService;

@RestController
@RolesAllowed({ MENU_ADMIN_QUERY_LOG })
@RequestMapping("/ui/v2")
public class UILogController {
    @Autowired
    private LogService logService;

    @PostMapping("/log/query")
    public QueryResponse<LogDto> queryLog(@RequestBody QueryRequest queryRequest) {
        return logService.query(queryRequest);
    }

    @GetMapping("/log/queryHeader")
    public List<QueryHeader> queryHeader() {
        return logService.queryHeader();
    }
}
