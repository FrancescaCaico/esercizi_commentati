package com.nbicocchi.product.persistence.model;

import lombok.*;

/*
QUESTO FILE DEFINISCE L'ENTITA' GENERALE DEL SERVIZIO --> IL PRODOTTO.
VIENE UTILIZZATA LA DIPENDENZA LOMBOK (INSERITA NEL POM.XML) PER DIMINUIRE IL CODICE ED EVITARE DI SCRIVERNE IN MODALITà
BOILERPLATE
L'ENTITA' PUO' ESSERE ISTANZIATA USANDO TRE TIPOLOGIE DI COSTRUTTORI:
- @AllArgsConstructor: genera un costruttore con un parametro per ogni campo. I campi contrassegnati con @NonNull includono controlli per null.
- @NoArgsConstructor: genera un costruttore senza argomenti. Se non è possibile a causa di campi finali, il compilatore genererà un errore a meno che non usi @NoArgsConstructor(force = true), che inizializza i campi finali con valori predefiniti (0, false o null).
                       I campi con vincoli come @NonNull non verranno controllati, quindi assicurati che quei campi siano inizializzati successivamente.
- @RequiredArgsConstructor: genera un costruttore per tutti i campi finali non inizializzati e i campi contrassegnati con @NonNull.
                            Un controllo per null viene aggiunto per i campi @NonNull.
I GETTER E I SETTER VENGONO AUTOMATICAMENTE DEFINITI USANDO LA MACRO @Data.

IN QUESTO CASO L'ENTITA' HA 4 ATTRIBUTI.
*/

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Product {
    private Long id;    // USATO IN AMBIENTE DI DB
    @NonNull @EqualsAndHashCode.Include private String uuid;    // LA CHIAVE PRIMARIA CHE IDENTIFICA LA RISORSA PRODOTTO NELL'INSIEME. PER SPECIFICARE CHE QUESTA è UNICA E NON RIPETIBILE SI USANO LE SEGUENTI ASSERZIONI:  @NonNull @EqualsAndHashCode.Include
    @NonNull private String name;
    @NonNull private Double weight;
}
