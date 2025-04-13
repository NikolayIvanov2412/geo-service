package ru.netology;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.netology.entity.Country;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;
import ru.netology.sender.MessageSender;
import ru.netology.sender.MessageSenderImpl;
import ru.netology.entity.Location;

public class MessageSenderTest {

    @Mock
    private GeoService geoService;

    @Mock
    private LocalizationService localizationService;

    private MessageSender messageSender;

    @Before
    public void setUp() {
        // Инициализация моков
        MockitoAnnotations.initMocks(this);

        // Создаем объект MessageSenderImpl
        messageSender = new MessageSenderImpl(geoService, localizationService);
    }

    @Test
    public void testRussianSegment() {
        // Настройка мока GeoService
        when(geoService.byIp("172.16.0.1"))
                .thenReturn(new Location("Москва", Country.RUSSIA, "Россия", 123)); // Исправлено

        // Настройка мока LocalizationService
        when(localizationService.locale(Country.RUSSIA))
                .thenReturn("Привет!");

        // Проверка результата
        assertEquals("", messageSender.sendMessage("172.16.0.1"));
    }

    @Test
    public void testAmericanSegment() {
        // Настройка мока GeoService
        when(geoService.byIp("96.10.20.30"))
                .thenReturn(new Location("Нью-Йорк", Country.USA, "США", 456)); // Исправлено

        // Настройка мока LocalizationService
        when(localizationService.locale(Country.USA))
                .thenReturn("Hello!");

        // Проверка результата
        assertEquals("", messageSender.sendMessage("96.10.20.30"));
    }
}