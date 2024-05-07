package org.example.spring.anno;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;

public class CustomGroupDeferredImportSelector implements DeferredImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        System.out.println("CustomGroupDeferredImportSelector.selectImports");
        return new String[]{"org.example.extra.SearchService"};
    }

    @Override
    public Class<? extends Group> getImportGroup() {
        System.out.println("CustomGroupDeferredImportSelector.getImportGroup");
        return MyGroup.class;
    }

    public static class MyGroup implements Group {
        @Override
        public void process(AnnotationMetadata metadata, DeferredImportSelector selector) {
            System.out.println("CustomGroupDeferredImportSelector.MyGroup.process");
        }

        @Override
        public Iterable<Entry> selectImports() {
            System.out.println("CustomGroupDeferredImportSelector.MyGroup.selectImports");
            return new ArrayList<>();
        }
    }

}
