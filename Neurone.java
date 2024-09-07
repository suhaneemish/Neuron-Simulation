class Neurone {

    Position position;  // Neuron's position in space
    double internalSignal;  // Neuron's internal signal
    double attenuationFactor;  // Factor to reduce signal strength
    ArrayList<Neurone> connections = new ArrayList<Neurone>();  // List of connected neurons

    // Default constructor
    Neurone() {
    }

    // Constructor to initialize neuron with position and attenuation factor
    Neurone(Position position, double attenuationFactor) {
        this.position = position;
        this.attenuationFactor = attenuationFactor;
        internalSignal = 0;  // Initial signal set to 0
    }

    // Get the position of the neuron
    public Position getPosition() {
        return position;
    }

    // Get the number of connections
    public int getNbConnections() {
        return connections.size();
    }

    // Get a specific connected neuron by index
    public Neurone getConnection(int index) {
        return connections.get(index);
    }

    // Get the attenuation factor
    public double getAttenuation() {
        return attenuationFactor;
    }

    // Get the current signal of the neuron
    public double getSignal() {
        return internalSignal;
    }

    // Connect this neuron to another neuron
    public void connect(Neurone n) {
        connections.add(n);
    }

    // Receive a stimulus, attenuate it, and propagate it to connected neurons
    public void receiveStimulus(double stimulus) {
        internalSignal = stimulus * attenuationFactor;
        for (Neurone neuron : connections) {
            neuron.receiveStimulus(internalSignal);
        }
    }

    // Converts the neuron information to a readable string format
    public String toString() {
        if (connections.size() == 0) {
            System.out.println("Neuron at position " + position + " with attenuation " + attenuationFactor + " has no connections.");
        } else {
            System.out.println("Neuron at position " + position + " with attenuation " + attenuationFactor + " connected to:");
            for (Neurone neuron : connections) {
                System.out.println("    - A neuron at position " + neuron.getPosition());
            }
        }
        return "";
    }
}
