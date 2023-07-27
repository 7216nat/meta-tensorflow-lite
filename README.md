# meta-tensorflow-lite

### Forked from [NobuoTsukamoto's repository]([recipes-framework/tensorflow-lite/python3-tensorflow-lite_2.8.0.bb](https://github.com/NobuoTsukamoto/meta-tensorflow-lite))

Yocto layer for the TensorFlow Lite interpreter with Python / C++.

## The official website is:
- [TensorFlow Lite guide](https://www.tensorflow.org/lite/guide)
- [Python quickstart](https://www.tensorflow.org/lite/guide/python)
- [TensorFlow Lite](https://github.com/tensorflow/tensorflow/tree/master/tensorflow/lite)

## Reference
- [Building TensorFlow Lite Standalone Pip](https://github.com/tensorflow/tensorflow/tree/master/tensorflow/lite/tools/pip_package)
- [Build TensorFlow Lite with CMake](https://github.com/tensorflow/tensorflow/blob/master/tensorflow/lite/g3doc/guide/build_cmake.md)


## Available recipes
- framework
  - [Python3 interpreter](recipes-framework/tensorflow-lite/python3-tensorflow-lite_2.8.0.bb)
  - [C++ API shared library](recipes-framework/tensorflow-lite/libtensorflow-lite_2.8.0.bb)
- examples
  - python3-tensorflow-lite-example  
    [TensorFlow Lite Python image classification demo](./doc/python3-tensorflow-lite-example.md)
  - tensorflow-lite-label-image  
    [TensorFlow Lite C++ image classification demo](./doc/tensorflow-lite-label-image.md)
  - tensorflow-lite-minimal  
    [TensorFlow Lite C++ minimal example](./doc/tensorflow-lite-minimal.md)
- tools
  - tensorflow-lite-benchmark  
    [TFLite Model Benchmark Tool with C++ Binary](./doc/tensorflow-lite-benchmark.md)
