protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);Fresco.initialize(this, ImagePipelineConfig config = ImagePipelineConfig.newBuilder(this).setDownsampleEnabled(true).build(););setContentView(R.layout.activity_main); nodeFlow = ((LocationFlowLayout) findViewById(R.id.nodeFlow));
    }