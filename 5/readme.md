# Redis assignment 5

## Sådan gør du:

1.  Klon dette repo og kør flg. docker kommando for at hente en container til at køre redis server i en container startet fra java test koden:

        docker pull testcontainers/ryuk:0.3.0

2.  Åbn projektet, f.eks. i intellij.
3.  Kør alle tests fra src/test/java folderen ved at højre-klikke og vælge 'run all tests'.
4. Observer, at alle tests er grønne. 

   ![tests.png](tests.png)

## Redis Data Model:

        USERS                       // alle brugere. Set.
        USER:username               // bruger. Hash.
        USER:username:FOLLOWEDBY    // brugers følgere. Set.
        USER:username:FOLLOWS       // brugere, bruger følger. Set.
        USER:username:POSTS         // ordnet Set, score er timestamp.

Hjælp til Redis kommandoer findes her: https://redis.io/commands/
