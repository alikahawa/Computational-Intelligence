import java.util.Random;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class Perceptron {

    double treshold;
    double[] weights;

    public void Train(double[][] input, double[] expectedOutput, double learningRate, int amountOfEpochs)
    {
        assertNotNull(input);
        assertNotNull(expectedOutput);

        // We need as many weights as we have inputs in a single input set
        // With this we do assume that every input has the same amount of data, maybe
        // this needs to be changed in the feature.
        weights = new double[input[0].length];
        treshold = 0.2;
        Random r = new Random();

        // Initialise the weights with random values between -0.5 and 0.5
        for(int i = 0; i < input[0].length; i++)
        {
            weights[i] = -0.5 + r.nextDouble();
        }

        // We want to do x amount of epochs
        for (int i = 0; i < amountOfEpochs; i++)
        {
            double epochError = 0;

            // We need to loop trough the expected outputs and check if the model
            // gives the right outputs with the corresponding input values.
            for (int j = 0; j < expectedOutput.length; j++)
            {
                // The error is the expected value minus the value which we get from our model.
                Double error = expectedOutput[j] - outputPerceptron(input[j]);

                for (int k = 0; k < input[j].length; k++) {

                    // We want to change the weight with respect to the error and
                    // with respect to the input values and learning rate.
                    double change = learningRate * input[j][k] * error;
                    weights[k] += change;
                    epochError += error;
                }
            }

            // If in none of the training data we make errors the combined error in the epoch
            // is zero, this means that our weights are optimally for the training data and we can
            // stop training
            if (epochError == 0)
            {
                break;
            }
        }
    }


    // This method adds all the weights multiplied with the inputs
    // and checks if it is enough for the treshold.
    public double outputPerceptron(double[] input)
    {
        Double sum = 0.0;

        for (int k = 0; k < input.length; k++) {
            sum += input[k] * weights[k];
        }

        // This implements the 'step' function.
       if (sum - treshold > 0)
            return 1.0;
        else return 0.0;
    }
}
