class Cerveau {

    ArrayList<Neurone> brain = new ArrayList<Neurone>();  // List of neurons in the brain

    // Constructor
    Cerveau() {
    }

    // Get the number of neurons in the brain
    public int getNbNeurons() {
        return brain.size();
    }

    // Get a specific neuron from the brain by index
    public Neurone getNeuron(int index) {
        return brain.get(index);
    }

    // Add a regular neuron to the brain with a specific position and attenuation factor
    public void addNeuron(Position pos, double attenuationFactor) {
        brain.add(new Neurone(pos, attenuationFactor));
    }

    // Add a cumulative neuron to the brain with a specific position and attenuation factor
    public void addCumulativeNeuron(Position pos, double attenuationFactor) {
        brain.add(new NeuroneCumulatif(pos, attenuationFactor));
    }

    // Stimulate a neuron by index with a given stimulus
    public void stimulate(int index, double stimulus) {
        brain.get(index).receiveStimulus(stimulus);
    }

    // Check the signal of a neuron by index
    public double probe(int index) {
        return brain.get(index).getSignal();
    }

    // Create connections between neurons
    public void createConnections() {
        int brainSize = brain.size();
        int brainIndex = 0;

        brain.get(brainIndex).connections.add(brain.get(brainIndex + 1));
        brain.get(brainIndex).connections.add(brain.get(brainIndex + 2));

        brainIndex += 1;

        if (brain.size() != 0) {
            while (brainIndex < brainSize - 2) {
                if (brainSize >= brainIndex + 1) {
                    brain.get(brainIndex).connections.add(brain.get(brainIndex + 1));
                }
                if (brainSize >= brainIndex + 2) {
                    brain.get(brainIndex + 1).connections.add(brain.get(brainIndex + 2));
                }
                brainIndex += 2;
            }
        }
    }

    // Converts the brain information to a readable string format
    public String toString() {
        System.out.println("The brain contains " + brain.size() + " neurons.");
        for (Neurone neuron : brain) {
            System.out.println(neuron);
        }
        return "";
    }
}
