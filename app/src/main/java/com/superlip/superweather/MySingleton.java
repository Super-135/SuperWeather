package com.superlip.superweather;

public class MySingleton {

    //Внутреннее поле, будет хранить единственный экземпляр
    private static MySingleton instance = null;

    // Поле для синхронизации
    private static final Object syncObj = new Object();

    // Это наш счетчик
    private String favouritesCity;

    // Конструктор (вызывать извне его нельзя, поэтому он приватный)
    private MySingleton(){
        favouritesCity = "";
    }

    // Увеличение счетчика
    public void incrementCounter(String str){
        favouritesCity = str;
    }

    public String getCounter(){
        return favouritesCity;
    }

    // Метод, который возвращает экземпляр объекта.
    // Если объекта нет, то создаем его.
    public static MySingleton getInstance(){
        // Здесь реализована «ленивая» инициализация объекта,
        // то есть, пока объект не нужен, не создаем его.
        synchronized (syncObj) {
            if (instance == null) {
                instance = new MySingleton();
            }
            return instance;
        }
    }

}
