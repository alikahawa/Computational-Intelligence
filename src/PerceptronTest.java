import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PerceptronTest {

    @Test
    public void testAND(){

        double inputs[][] = {{0,0},{0,1},{1,0},{1,1}};
        double outputs[] = {0,0,0,1};

        Perceptron p = new Perceptron();
        p.Train(inputs, outputs,0.1, 50);

        assertEquals(p.outputPerceptron(new double[]{0,0}),0.0);
        assertEquals(p.outputPerceptron(new double[]{0,1}),0.0);
        assertEquals(p.outputPerceptron(new double[]{1,0}),0.0);
        assertEquals(p.outputPerceptron(new double[]{1,1}),1.0);
    }

    @Test
    public void testOR(){

        double inputs[][] = {{0,0},{0,1},{1,0},{1,1}};
        double outputs[] = {0,1,1,1};

        Perceptron p = new Perceptron();
        p.Train(inputs, outputs,0.1, 50);

        assertEquals(p.outputPerceptron(new double[]{0,0}),0.0);
        assertEquals(p.outputPerceptron(new double[]{0,1}),1.0);
        assertEquals(p.outputPerceptron(new double[]{1,0}),1.0);
        assertEquals(p.outputPerceptron(new double[]{1,1}),1.0);
    }
}
