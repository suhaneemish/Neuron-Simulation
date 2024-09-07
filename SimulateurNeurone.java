class SimulateurNeurone {

    public static void main(String[] args) {
        // PART 1 TEST
        System.out.println("Test Part 1:");
        System.out.println("--------------------");

        Position position1 = new Position(0, 1);
        Position position2 = new Position(1, 0);
        Position position3 = new Position(1, 1);

        Neurone neuron1 = new Neurone(position1, 0.5);
        Neurone neuron2 = new Neurone(position2, 1.0);
        Neurone neuron3 = new Neurone(position3, 2.0);

        neuron1.connect(neuron2);
        neuron2.connect(neuron3);
        neuron1.receiveStimulus(10);

        System.out.println("Signals:");
        System.out.println(neuron1.getSignal());
        System.out.println(neuron2.getSignal());
        System.out.println(neuron3.getSignal());

        System.out.println();
        System.out.println("First connection of neuron 1");
        System.out.println(neuron1.getConnection(0));

        // END PART 1 TEST

        // PART 2 TEST
        System.out.println("Test Part 2:");
        System.out.println("--------------------");

        Position position5 = new Position(0, 0);
        NeuroneCumulatif neuron5 = new NeuroneCumulatif(position5, 0.5);
        neuron5.receiveStimulus(10);
        neuron5.receiveStimulus(10);
        System.out.println("Cumulative neuron signal -> " + neuron5.getSignal());

        // END PART 2 TEST

        // PART 3 TEST
        System.out.println();
        System.out.println("Test Part 3:");
        System.out.println("--------------------");
        Cerveau brain = new Cerveau();

        // Create regular neurons with position and attenuation factor
        brain.addNeuron(new Position(0, 0), 0.5);
        brain.addNeuron(new Position(0, 1), 0.2);
        brain.addNeuron(new Position(1, 0), 1.0);

        // Create cumulative neurons with position and attenuation factor
        brain.addCumulativeNeuron(new Position(1, 1), 0.8);
        brain.createConnections();
        brain.stimulate(0, 10);

        System.out.println("Signal of the 3rd neuron -> " + brain.probe(3));
        System.out.println(brain);

        // END PART 3 TEST
    }
}
