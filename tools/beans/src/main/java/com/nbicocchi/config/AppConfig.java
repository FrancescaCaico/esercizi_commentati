package com.nbicocchi.config;

import com.nbicocchi.beans.BeanB;
import com.nbicocchi.beans.BeanC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/*
* L'annotazione @Configuration indica a Spring che questa classe contiene la definizione di uno o più bean.
* È un modo per definire la configurazione dell'applicazione in modo programmatico piuttosto che in un file XML.
*
* I metodi annotati con @Bean indicano a Spring che il valore restituito da questi metodi deve essere gestito come un bean.
* In questo caso, ci sono due metodi:

    beanB(): Restituisce un'istanza di BeanB con uno scope singleton
    beanC(): Restituisce un'istanza di BeanC con uno scope stereotype

*
Gli attributi initMethod e destroyMethod specificano i nomi dei metodi che devono essere invocati rispettivamente per l'inizializzazione e la distruzione del bean. Ciò consente di eseguire logica personalizzata quando il bean è creato o distrutto.
    initialize: metodo chiamato dopo che il bean è stato istanziato.
    destroy: metodo chiamato prima che il bean venga distrutto.

*
*/


@Configuration
public class AppConfig {
    @Bean(initMethod="initialize", destroyMethod="destroy")
    @Scope("singleton")
    public BeanB beanB() {
        return new BeanB();
    }

    @Bean(initMethod="initialize", destroyMethod="destroy")
    @Scope("prototype")
    public BeanC beanC() {
        return new BeanC();
    }
}
