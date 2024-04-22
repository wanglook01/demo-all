package org.example;

import org.example.adaptor.PassportGateway;
import org.example.aggregate.group.domainservice.GroupDomainService;
import org.example.aggregate.group.repository.GroupRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public GroupDomainService groupDomainService(GroupRepository groupRepository,
                                                 PassportGateway passportGateway) {
        return new GroupDomainService(groupRepository, passportGateway);
    }
}
