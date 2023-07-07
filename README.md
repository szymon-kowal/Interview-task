## README

Do napisania kodu została użyta werjsa Oracle OpenJDK version 20.0.1.

Wprowadziłem pewne założenia do projektu:
1) Klasa Composite zawiera w sobie n elementów, które są klasami Block a sam w sobie nie posiada żadnych własności.
2) Wprowadzany input do metod jako "List<'Block'>" może zarówno zawierać w sobie pojedyńcze Block, jak i Composite, 
   przez co należało napisać odpowiedni kod, który rozróżnia czy danym elementem jest Block czy Composite 
   a jak jest nim Composite to należy iterować po jego elementach.
   

Na podstawie otrzymanego zadania napisałem kod w którym:
W pliku Wall.java znajduje się logika, oraz odpowiednie klasy i metody.
W pliku Main.java znajduje się głowny kod, który wywołuje odpowiednie metody.
Pliki Data1, Data2, Data3 zostały stworzone w celu testowania outputu.

Podane pliki należy skompilować a następnie wybrać odpowiedni plik danych i zmienić jego nazwę
w folderze Main.java a następnie uruchomić plik Main.java.
