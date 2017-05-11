package nl.differentcook.bierexpert.component;

import javax.inject.Singleton;

import dagger.Component;
import nl.differentcook.bierexpert.model.Bierexpert;
import nl.differentcook.bierexpert.module.BierexpertModule;

@Singleton
@Component(modules = {BierexpertModule.class})
public interface BierexpertComponent {

    Bierexpert provideBierexpert();

}
