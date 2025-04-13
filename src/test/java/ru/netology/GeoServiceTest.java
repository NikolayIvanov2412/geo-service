package ru.netology;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import ru.netology.entity.Country;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;

public class GeoServiceTest {

    private GeoService geoService = new GeoServiceImpl();

    @Test
    public void testByIpRussia() {
        // Проверка определения страны для российского сегмента
        assertEquals(Country.RUSSIA, geoService.byIp("172.16.0.1").getCountry());
    }

    @Test
    public void testByIpUsa() {
        // Проверка определения страны для американского сегмента
        assertEquals(Country.USA, geoService.byIp("96.10.20.30").getCountry());
    }
}