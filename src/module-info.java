module ExampleApp {
	exports de.tum.cit.aet;

	requires javafx.controls;
	requires javafx.graphics;

	opens de.tum.cit.aet to javafx.controls, javafx.graphics;
}
