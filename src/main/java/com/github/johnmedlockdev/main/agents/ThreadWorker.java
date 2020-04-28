package com.github.johnmedlockdev.main.agents;

class ThreadWorker implements Runnable {
    private final String symbol;
    private final String numberOfInputs;

    public ThreadWorker(String symbol, String numberOfInputs) {
        this.symbol = symbol;
        this.numberOfInputs = numberOfInputs;
    }

    @Override
    public void run() {
        new Demo(symbol, numberOfInputs).generate();
    }
}