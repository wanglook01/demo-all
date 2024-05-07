package org.example.spring.anno;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class CustomImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        System.out.println("CustomImportSelector.selectImports");
        return new String[]{"org.example.extra.SearchService"};
    }
}
