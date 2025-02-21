package exercicedeux.domain;

import java.util.List;

public class Patient {
    private final int whiteBloodCellCount;
    private final boolean isInGammaProtocol;
    private final boolean isRelapsingAfter2019;
    private final List<String> geneticMarkers;

    public Patient(int whiteBloodCellCount, boolean isInGammaProtocol, boolean isRelapsingAfter2019, List<String> geneticMarkers) {
        this.whiteBloodCellCount = whiteBloodCellCount;
        this.isInGammaProtocol = isInGammaProtocol;
        this.isRelapsingAfter2019 = isRelapsingAfter2019;
        this.geneticMarkers = geneticMarkers;
    }

    public int getWhiteBloodCellCount() { return whiteBloodCellCount; }
    public boolean isInGammaProtocol() { return isInGammaProtocol; }
    public boolean isRelapsingAfter2019() { return isRelapsingAfter2019; }
    public List<String> getGeneticMarkers() { return geneticMarkers; }
}