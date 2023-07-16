DESCRIPTION = "TensorFlow Lite Python image classification demo"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4158a261ca7f2525513e31ba9c50ae98"

# Compute branch info from ${PV} as Base PV...
BPV = "${@'.'.join(d.getVar('PV').split('.')[0:2])}"
DPV = "${@'.'.join(d.getVar('PV').split('.')[0:3])}"

SRCREV_tensorflow = "1b8f5c396f0c016ebe81fe1af029e6f205c926a4"

SRC_URI[model.sha256sum] = "1ccb74dbd9c5f7aea879120614e91617db9534bdfaa53dfea54b7c14162e126b"
SRC_URI[label.sha256sum] = "366a2d53008df0d2a82b375e2020bbc57e43bbe19971370e47b7f74ea0aaab91"
SRC_URI[sort.sha256sum] = "6a98f9c16cb60d746b70f9aef920a7705f2158d65678efe5fc90ef9d47db841d"
SRC_URI[example-object-tracker.sha256sum] = "99315d401874ffbadc783105cf13999e61839bec9ab2debf88855bfa8294dc63"
SRC_URI[model2.sha256sum] = "1df6f563746346d656c58aa2ae801b32f2a29e4e4adee46a65aeac6decc5f887"
SRC_URI[label2.sha256sum] = "93f235896748537fc71325a070ee32e9a0afda2481ceb943559325619763fa6d"

SRC_URI = " \
    git://github.com/tensorflow/tensorflow.git;name=tensorflow;branch=r2.8;protocol=https \
    https://github.com/abewley/sort/archive/master.zip;name=sort \
    https://github.com/google-coral/example-object-tracker/archive/master.tar.gz;name=example-object-tracker \
    https://storage.googleapis.com/download.tensorflow.org/models/mobilenet_v1_2018_02_22/mobilenet_v1_1.0_224.tgz;name=model \
    https://dl.google.com/coral/canned_models/mobilenet_ssd_v2_coco_quant_postprocess_edgetpu.tflite;name=model2 \
    https://storage.googleapis.com/download.tensorflow.org/models/mobilenet_v1_1.0_224_frozen.tgz;name=label \
    https://dl.google.com/coral/canned_models/coco_labels.txt;name=label2 \
    file://001-v2.8_label_image_py.patch \
"

DEPENDS = " \
    gstreamer1.0 gstreamer1.0-plugins-base gstreamer1.0-plugins-bad unzip-native\
"
INSANE_SKIP_${PN} = "file-rdeps"


RDEPENDS:${PN} += " \
    python3-tensorflow-lite\
    python3-pillow \
    rpi-gpio \
    python3-svgwrite \
    python3-lap \
    python3-pygobject \
    python3-filterpy \
    python3-matplotlib \
    python3-skimage \
    python3-packaging \
    gstreamer1.0-plugins-base \
    gstreamer1.0-plugins-good \
    gstreamer1.0-plugins-bad \
"

S = "${WORKDIR}/git"

do_install:append() {
    install -d ${D}${datadir}/tensorflow/lite/examples/python
    install -d ${D}${datadir}/tensorflow/lite/examples/python/example-object-tracker
    install -d ${D}${datadir}/tensorflow/lite/examples/python/example-object-tracker/gstreamer
    install -d ${D}${datadir}/tensorflow/lite/examples/python/example-object-tracker/third_party
    install -d ${D}${datadir}/tensorflow/lite/examples/python/example-object-tracker/third_party/sort-master
    install -d ${D}${datadir}/tensorflow/lite/examples/python/example-object-tracker/models
    install -m 644 ${S}/tensorflow/lite/examples/python/label_image.py ${D}${datadir}/tensorflow/lite/examples/python/
    install -m 644 ${WORKDIR}/example-object-tracker-master/gstreamer/*.py ${D}${datadir}/tensorflow/lite/examples/python/example-object-tracker/gstreamer/
    install -m 644 ${S}/tensorflow/lite/examples/label_image/testdata/grace_hopper.bmp ${D}${datadir}/tensorflow/lite/examples/python/
    cp -R ${WORKDIR}/sort-master/* ${D}${datadir}/tensorflow/lite/examples/python/example-object-tracker/third_party/sort-master/
    install -m 644 ${WORKDIR}/mobilenet_v1_1.0_224.tflite ${D}${datadir}/tensorflow/lite/examples/python/
    install -m 644 ${WORKDIR}/mobilenet_ssd_v2_coco_quant_postprocess_edgetpu.tflite ${D}${datadir}/tensorflow/lite/examples/python/example-object-tracker/models/    
    install -m 644 ${WORKDIR}/coco_labels.txt ${D}${datadir}/tensorflow/lite/examples/python/example-object-tracker/models/
    install -m 644 ${WORKDIR}/mobilenet_v1_1.0_224/labels.txt ${D}${datadir}/tensorflow/lite/examples/python/
}



FILES:${PN} += "${datadir}/tensorflow/lite/examples/python/*"
