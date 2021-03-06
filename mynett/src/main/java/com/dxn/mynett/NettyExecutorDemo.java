package com.dxn.mynett;

public class NettyExecutorDemo {
    public static void main(String[] args) {
        LoopExecutor loopExecutor = new LoopExecutor();
        final Loop choose = loopExecutor.choose();
        System.out.println("choose = " + choose);
    }
}


class EventExecutor {
    EventFactory factory;

    public EventExecutor(EventFactory eventFactory) {
        this.factory = eventFactory;
    }

    public Event choose() {
        return factory.create();
    }
}

class LoopExecutor extends EventExecutor {

    public LoopExecutor() {
        super(new LoopFactory());
    }

    @Override
    public Loop choose() {
        return (Loop) super.choose();
    }
}

class Event {
}

class Loop extends Event {
}

interface EventFactory {
    Event create();
}

class LoopFactory implements EventFactory {
    public Loop create() {
        return new Loop();
    }
}

class MyEvent extends Event {
}