// constructor
public EarthquakeMarker (PointFeature f) 
{
	super(f.getLocation());
	// Add a radius property and then set the properties
java.util.HashMap<String, Object> p = f.getProperties();
float m = Float.parseFloat(properties.get("m").toString());
	properties.put("radius", 2*m );
setProperties(p);
this.radius = 1.75f*getMagnitude();
}