package company.xiao20180628;

import java.lang.reflect.Field;

public class AnnotationUtil {

    public void getAskQuestionName(Class<?> clazz) {
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(AskQuestion.class)) {
                AskQuestion askQuestion = field.getAnnotation(AskQuestion.class);
                System.out.println(askQuestion.questionName());
            }
        }
    }

}
