import java.lang.reflect.Method;

public class AnnotationProcessor {

    public static void process(Object input){
        Class<?> cl = input.getClass();
        Method[] methods = cl.getDeclaredMethods();
        for (Method method : methods){
            AutoCallable ann = method.getAnnotation(AutoCallable.class);

            if (ann == null){
                continue;
            }

            int count = ann.count();

            for ( int i = 0; i < count; i++){
                try {
                    method.invoke(input);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        }
    }
}
