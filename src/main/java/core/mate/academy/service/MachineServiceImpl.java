package core.mate.academy.service;

import core.mate.academy.model.Bulldozer;
import core.mate.academy.model.Excavator;
import core.mate.academy.model.Machine;
import core.mate.academy.model.Truck;
import java.util.ArrayList;
import java.util.List;

/**
 * Your implementation of MachineService.
 */
public class MachineServiceImpl<T extends Machine> implements MachineService<T> {
    private final MachineProducer<Bulldozer> bulldozerProducer;
    private final MachineProducer<Excavator> excavatorProducer;
    private final MachineProducer<Truck> truckProducer;

    public MachineServiceImpl() {
        this.bulldozerProducer = new BulldozerProducer();
        this.excavatorProducer = new ExcavatorProducer();
        this.truckProducer = new TruckProducer();
    }

    public MachineServiceImpl(MachineProducer<Bulldozer> bulldozerProducer,
                              MachineProducer<Excavator> excavatorProducer,
                              MachineProducer<Truck> truckProducer) {
        this.bulldozerProducer = bulldozerProducer;
        this.excavatorProducer = excavatorProducer;
        this.truckProducer = truckProducer;
    }

    @Override
    public List<T> getAll(Class<? extends Machine> type) {
        if (type == Bulldozer.class) {
            return (List<T>)bulldozerProducer.get();
        }
        if (type == Excavator.class) {
            return (List<T>)excavatorProducer.get();
        }
        if (type == Truck.class) {
            return (List<T>)truckProducer.get();
        }
        return new ArrayList<>();
    }

    @Override
    public void fill(List<? super T> machines, T value) {
        for (int i = 0; i < machines.size(); i++) {
            machines.set(i, value);
        }
    }

    @Override
    public void startWorking(List<? extends T> machines) {
        for (T machine : machines) {
            machine.doWork();
        }
    }
}
