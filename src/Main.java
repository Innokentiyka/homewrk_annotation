public class Main {


    static class Demo {
        private final StdOut stdOut = new StdOut();
        private final StdError stdError = new StdError();

        @AutoCallable(count = 3)
        public void printToStdOut() {
            stdOut.call();
        }

        @AutoCallable
        public void printToStdError() {
            stdError.call();
        }

        @AutoCallable(count = 2)
        public void anotherMessage() {
            System.out.println("Ещё одно сообщение");
        }
    }

    public static void main(String[] args) {

        AnnotationProcessor.process(new Demo());
    }
}