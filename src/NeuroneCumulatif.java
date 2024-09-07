class NeuroneCumulatif extends Neurone {

    // Constructor for cumulative neuron with position and attenuation factor
    NeuroneCumulatif(Position position, double attenuationFactor) {
        super(position, attenuationFactor);
    }

    // Receives stimulus and accumulates signal instead of replacing it
    public void receiveStimulus(double stimulus) {
        internalSignal += stimulus * attenuationFactor;
        for (Neurone neuron : connections) {
            neuron.receiveStimulus(internalSignal);
        }
    }

    // Get the current cumulative signal
    public double getSignal() {
        return internalSignal;
    }
}
