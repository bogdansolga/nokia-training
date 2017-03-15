package com.nokia.training.d01.s05;

@TrainingSession(
        day = TrainingDay.D01,
        topic = "annotations",
        subTopics = {
                "annotation",
                "processing",
                "overriding"
        }
)
public class ProductProcessorImpl extends ProductProcessor {
    @Override // @Implements
    public void process(Product product) {
    }

    @Override
    void contractEnforce(Product product) {
        System.out.println("From extending class - " + product);
    }
}
