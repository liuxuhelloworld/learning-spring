import org.springframework.context.support.GenericXmlApplicationContext;

public class InjectCollectionValuesUsingXmlApplication {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("app-context.xml");
        ctx.refresh();

        CollectionInjection instance = ctx.getBean("collectionInjection", CollectionInjection.class);
        instance.displayInfo();

        ctx.close();
    }
}
