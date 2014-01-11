

package com.glob3.mobile.owm.shared.data;

import java.util.ArrayList;

import org.glob3.mobile.generated.BingMapType;
import org.glob3.mobile.generated.BingMapsLayer;
import org.glob3.mobile.generated.LayerBuilder;
import org.glob3.mobile.generated.LayerSet;
import org.glob3.mobile.generated.LevelTileCondition;
import org.glob3.mobile.generated.MapBoxLayer;
import org.glob3.mobile.generated.MapQuestLayer;
import org.glob3.mobile.generated.MercatorTiledLayer;
import org.glob3.mobile.generated.OSMLayer;
import org.glob3.mobile.generated.Sector;
import org.glob3.mobile.generated.TimeInterval;
import org.glob3.mobile.generated.URL;
import org.glob3.mobile.generated.URLTemplateLayer;
import org.glob3.mobile.generated.WMSLayer;
import org.glob3.mobile.generated.WMSServerVersion;


public class SimpleRasterLayerBuilder
         extends
            LayerBuilder {

   public static LayerSet createLayerset() {
      final LayerSet layerSet = new LayerSet();


      final MapQuestLayer mqOSM = MapQuestLayer.newOSM(TimeInterval.fromDays(30));
      mqOSM.setEnable(false);
      mqOSM.setTitle("MapQuest OSM");
      layerSet.addLayer(mqOSM);

      final MapQuestLayer mqlAerial = MapQuestLayer.newOpenAerial(TimeInterval.fromDays(30));
      mqlAerial.setTitle("MapQuest Aerial");
      mqlAerial.setEnable(false);
      layerSet.addLayer(mqlAerial);

      final MapBoxLayer mboxAerialLayer = new MapBoxLayer("examples.map-m0t0lrpu", TimeInterval.fromDays(30), true, 2);
      mboxAerialLayer.setTitle("Map Box Aerial");
      mboxAerialLayer.setEnable(false);
      layerSet.addLayer(mboxAerialLayer);

      final MapBoxLayer mboxTerrainLayer = new MapBoxLayer("examples.map-9ijuk24y", TimeInterval.fromDays(30), true, 2);
      mboxTerrainLayer.setTitle("Map Box Terrain");
      mboxTerrainLayer.setEnable(false);
      layerSet.addLayer(mboxTerrainLayer);

      //      final MapBoxLayer mboxOSMLayer = new MapBoxLayer("examples.map-cnkhv76j", TimeInterval.fromDays(30), true, 2);
      //      mboxOSMLayer.setTitle("Map Box OSM");
      //      mboxOSMLayer.setEnable(true);
      //      layerSet.addLayer(mboxOSMLayer);

      final WMSLayer blueMarble = new WMSLayer("bmng200405", new URL("http://www.nasa.network.com/wms?", false),
               WMSServerVersion.WMS_1_1_0, Sector.fullSphere(), "image/jpeg", "EPSG:4326", "", false, new LevelTileCondition(0,
                        18), TimeInterval.fromDays(30), true);
      blueMarble.setTitle("WMS Nasa Blue Marble");
      blueMarble.setEnable(false);
      layerSet.addLayer(blueMarble);


      final OSMLayer osmLayer = new OSMLayer(TimeInterval.fromDays(30));
      osmLayer.setTitle("Open Street Map");
      osmLayer.setEnable(false);
      layerSet.addLayer(osmLayer);

      final BingMapsLayer bingMapsAerialLayer = new BingMapsLayer(BingMapType.Aerial(),
               "AnU5uta7s5ql_HTrRZcPLI4_zotvNefEeSxIClF1Jf7eS-mLig1jluUdCoecV7jc", TimeInterval.fromDays(30));
      bingMapsAerialLayer.setTitle("Bing Aerial");
      bingMapsAerialLayer.setEnable(false);
      layerSet.addLayer(bingMapsAerialLayer);

      final BingMapsLayer bingMapsAerialWithLabels = new BingMapsLayer(BingMapType.AerialWithLabels(),
               "AnU5uta7s5ql_HTrRZcPLI4_zotvNefEeSxIClF1Jf7eS-mLig1jluUdCoecV7jc", TimeInterval.fromDays(30));
      bingMapsAerialWithLabels.setTitle("Bing Aerial With Labels");
      bingMapsAerialWithLabels.setEnable(false);
      layerSet.addLayer(bingMapsAerialWithLabels);

      final BingMapsLayer bingMapsCollinsBart = new BingMapsLayer(BingMapType.CollinsBart(),
               "AnU5uta7s5ql_HTrRZcPLI4_zotvNefEeSxIClF1Jf7eS-mLig1jluUdCoecV7jc", TimeInterval.fromDays(30));
      bingMapsCollinsBart.setTitle("MapQuest OSM");
      bingMapsCollinsBart.setEnable(false);
      layerSet.addLayer(bingMapsCollinsBart);

      final ArrayList<String> subdomains = new ArrayList<String>();
      subdomains.add("0.");
      subdomains.add("1.");
      subdomains.add("2.");
      subdomains.add("3.");

      final MercatorTiledLayer meteoritesLayer = new MercatorTiledLayer("CartoDB-meteoritessize", "http://",
               "tiles.cartocdn.com/osm2/tiles/meteoritessize", subdomains, "png", TimeInterval.fromDays(90), false,
               Sector.fullSphere(), 2, 17, null);
      meteoritesLayer.setTitle("CartoDB Meteorites");
      meteoritesLayer.setEnable(false);
      layerSet.addLayer(meteoritesLayer);

      final URLTemplateLayer arcGISOverlayLayerTest = URLTemplateLayer.newMercator(
               "http://www.fairfaxcounty.gov/gis/rest/services/DMV/DMV/MapServer/export?dpi=96&transparent=true&format=png8&bbox={west}%2C{south}%2C{east}%2C{north}&bboxSR=3857&imageSR=3857&size={width}%2C{height}&f=image",
               Sector.fullSphere(), true, 2, 18, TimeInterval.fromDays(30), true, new LevelTileCondition(12, 18));
      arcGISOverlayLayerTest.setTitle("ESRI ArcGis Online");
      arcGISOverlayLayerTest.setEnable(false);
      layerSet.addLayer(arcGISOverlayLayerTest);

      final URLTemplateLayer precipitationOWM = URLTemplateLayer.newMercator(
               "http://undefined.tile.openweathermap.org/map/precipitation/{level}/{x}/{y}.png", Sector.fullSphere(), true, 1,
               18, TimeInterval.zero(), true, new LevelTileCondition(1, 18), 0.5f);
      precipitationOWM.setTitle("Precipitation");
      precipitationOWM.setEnable(false);
      layerSet.addLayer(precipitationOWM);

      final URLTemplateLayer cloudsOWM = URLTemplateLayer.newMercator(
               "http://undefined.tile.openweathermap.org/map/clouds/{level}/{x}/{y}.png", Sector.fullSphere(), true, 1, 18,
               TimeInterval.zero(), true, new LevelTileCondition(1, 18), 0.8f);
      cloudsOWM.setTitle("Clouds");
      cloudsOWM.setEnable(false);
      layerSet.addLayer(cloudsOWM);


      final URLTemplateLayer pressureOWM = URLTemplateLayer.newMercator(
               "http://undefined.tile.openweathermap.org/map/pressure/{level}/{x}/{y}.png", Sector.fullSphere(), true, 1, 18,
               TimeInterval.zero(), true, new LevelTileCondition(1, 18), 0.5f);
      pressureOWM.setTitle("Pressure");
      pressureOWM.setEnable(false);
      layerSet.addLayer(pressureOWM);


      final URLTemplateLayer pressureContourOWM = URLTemplateLayer.newMercator(
               "http://undefined.tile.openweathermap.org/map/pressure_cntr/{level}/{x}/{y}.png", Sector.fullSphere(), true, 1,
               18, TimeInterval.zero(), true, new LevelTileCondition(1, 18));
      pressureContourOWM.setTitle("Pressure Contour");
      pressureContourOWM.setEnable(false);
      layerSet.addLayer(pressureContourOWM);


      final URLTemplateLayer windOWM = URLTemplateLayer.newMercator(
               "http://undefined.tile.openweathermap.org/map/wind/{level}/{x}/{y}.png", Sector.fullSphere(), true, 1, 18,
               TimeInterval.zero(), true, new LevelTileCondition(1, 18), 0.5f);
      windOWM.setTitle("Wind");
      windOWM.setEnable(false);
      layerSet.addLayer(windOWM);


      final URLTemplateLayer temperatureOWM = URLTemplateLayer.newMercator(
               "http://undefined.tile.openweathermap.org/map/temp/{level}/{x}/{y}.png", Sector.fullSphere(), true, 1, 18,
               TimeInterval.fromDays(30), true, new LevelTileCondition(1, 18), 0.5f);
      temperatureOWM.setTitle("Temperature");
      temperatureOWM.setEnable(false);
      layerSet.addLayer(temperatureOWM);


      final URLTemplateLayer snowOWM = URLTemplateLayer.newMercator(
               "http://undefined.tile.openweathermap.org/map/snow/{level}/{x}/{y}.png", Sector.fullSphere(), true, 1, 18,
               TimeInterval.zero(), true, new LevelTileCondition(1, 18));
      snowOWM.setTitle("Snow");
      snowOWM.setEnable(false);
      layerSet.addLayer(snowOWM);


      return layerSet;
   }
}
