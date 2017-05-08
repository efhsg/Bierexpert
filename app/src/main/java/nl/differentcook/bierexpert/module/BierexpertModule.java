package nl.differentcook.bierexpert.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import nl.differentcook.bierexpert.model.Bierexpert;

@Module
public class BierexpertModule {

    @Provides
    @Singleton
    Bierexpert provideBierexpert() {
        return new Bierexpert();
    }

}
