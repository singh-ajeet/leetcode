public class LocalRasterEngine extends AbstractRasterEngine  {

    public static AbstractRasterEngine  get() {
        return LocalRasterEngineHolder.RASTER_ENGINE;
    }

    private static class LocalRasterEngineHolder {
        private static AbstractRasterEngine RASTER_ENGINE = new LocalRasterEngine();
    }
}
