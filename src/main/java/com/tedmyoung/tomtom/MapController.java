package com.tedmyoung.tomtom;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MapController {

  @Value("${tomtom.apikey}")
  private String tomTomApiKey;

  @GetMapping("/")
  public String homePage(Model model) {
    model.addAttribute("apikey", tomTomApiKey);
    model.addAttribute("coolLocations", coolLocations());
    return "home";
  }

  private List<Location> coolLocations() {
    return List.of(
        new Location(new double[]{-121.901481, 36.618253}, "Monterey Bay Aquarium"),
        new Location(new double[]{21.006010, 52.231606}, "Palace of Culture and Science"),
        new Location(new double[]{2.337612, 48.860717}, "Louvre Museum")
    );
  }

  private static class Location {
    private final double[] lnglat;
    private final String description;

    public Location(double[] lnglat, String description) {
      this.lnglat = lnglat;
      this.description = description;
    }

    public double[] getLnglat() {
      return lnglat;
    }

    public String getDescription() {
      return description;
    }
  }

}
