// constructor
public EarthquakeMarker (PointFeature feature) 
{
	super(feature.getLocation());
	// Add a radius property and then set the properties
	java.util.HashMap<String, Object> properties = feature.getProperties();
	float magnitude = Float.parseFloat(properties.get("magnitude").toString());
	properties.put("radius", 2*magnitude );
	setProperties(properties);
	this.radius = 1.75f*getMagnitude();
}