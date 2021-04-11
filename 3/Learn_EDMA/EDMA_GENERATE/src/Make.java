import org.abstractica.edma.generator.EdmaGenerator;

public class Make
{
    public static void main(String[] args)
    {
        String projectDir = "C:\\Users\\Claus\\CloudStation\\Bsc 2020\\2 semester\\DBD\\Exercises\\EDMA\\Learn_EDMA";

        EdmaGenerator edmaGenerator = new EdmaGenerator("LearnEDMA", projectDir+"\\edmasrc", projectDir + "\\src", "dk.ck.learnedma");
        edmaGenerator.make();
    }
}
