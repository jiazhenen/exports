<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
    <style type="text/css">
        body, html {width: 100%;height: 100%;margin:0;font-family:"微软雅黑";}
        #allmap{width:100%;height:500px;}
        p{margin-left:5px; font-size:14px;}
    </style>
    <script type="text/javascript" src="//api.map.baidu.com/api?v=3.0&ak=您的密钥"></script>
    <title>个性化地图</title>
</head>
<body>
<div id="allmap"></div>
<p>个性化底图V2样式可通过<a href='/customv2/help.html' target="_blank">个性化在线编辑器</a>编辑获取</p>
</body>
</html>
<script type="text/javascript">
    var map = new BMap.Map('allmap');
    map.centerAndZoom(new BMap.Point(116.404269,39.916042), 12);

    map.enableScrollWheelZoom();                         //启用滚轮放大缩小

    var styleJson = [
        {
            'featureType': 'land',
            'elementType': 'geometry',
            'stylers': {
                'visibility': 'on',
                'color': '#ffffffff'
            }
        }, {
            'featureType': 'water',
            'elementType': 'geometry',
            'stylers': {
                'visibility': 'on',
                'color': '#ff5400ff'
            }
        }, {
            'featureType': 'green',
            'elementType': 'geometry',
            'stylers': {
                'visibility': 'on',
                'color': '#ff54006e'
            }
        }, {
            'featureType': 'building',
            'elementType': 'geometry',
            'stylers': {
                'visibility': 'on'
            }
        }, {
            'featureType': 'building',
            'elementType': 'geometry.fill',
            'stylers': {
                'color': '#ffffffb3'
            }
        }, {
            'featureType': 'building',
            'elementType': 'geometry.stroke',
            'stylers': {
                'color': '#dadadab3'
            }
        }, {
            'featureType': 'subwaystation',
            'elementType': 'geometry',
            'stylers': {
                'visibility': 'on',
                'color': '#b15454B2'
            }
        }, {
            'featureType': 'education',
            'elementType': 'geometry',
            'stylers': {
                'visibility': 'on',
                'color': '#e4f1f1ff'
            }
        }, {
            'featureType': 'medical',
            'elementType': 'geometry',
            'stylers': {
                'visibility': 'on',
                'color': '#f0dedeff'
            }
        }, {
            'featureType': 'scenicspots',
            'elementType': 'geometry',
            'stylers': {
                'visibility': 'on',
                'color': '#e2efe5ff'
            }
        }, {
            'featureType': 'highway',
            'elementType': 'geometry',
            'stylers': {
                'visibility': 'on',
                'weight': 4
            }
        }, {
            'featureType': 'highway',
            'elementType': 'geometry.fill',
            'stylers': {
                'color': '#f7c54dff'
            }
        }, {
            'featureType': 'highway',
            'elementType': 'geometry.stroke',
            'stylers': {
                'color': '#fed669ff'
            }
        }, {
            'featureType': 'highway',
            'elementType': 'labels',
            'stylers': {
                'visibility': 'on'
            }
        }, {
            'featureType': 'highway',
            'elementType': 'labels.text.fill',
            'stylers': {
                'color': '#8f5a33ff'
            }
        }, {
            'featureType': 'highway',
            'elementType': 'labels.text.stroke',
            'stylers': {
                'color': '#ffffffff'
            }
        }, {
            'featureType': 'highway',
            'elementType': 'labels.icon',
            'stylers': {
                'visibility': 'on'
            }
        }, {
            'featureType': 'arterial',
            'elementType': 'geometry',
            'stylers': {
                'visibility': 'on',
                'weight': 2
            }
        }, {
            'featureType': 'arterial',
            'elementType': 'geometry.fill',
            'stylers': {
                'color': '#d8d8d8ff'
            }
        }, {
            'featureType': 'arterial',
            'elementType': 'geometry.stroke',
            'stylers': {
                'color': '#ffeebbff'
            }
        }, {
            'featureType': 'arterial',
            'elementType': 'labels',
            'stylers': {
                'visibility': 'on'
            }
        }, {
            'featureType': 'arterial',
            'elementType': 'labels.text.fill',
            'stylers': {
                'color': '#525355ff'
            }
        }, {
            'featureType': 'arterial',
            'elementType': 'labels.text.stroke',
            'stylers': {
                'color': '#ffffffff'
            }
        }, {
            'featureType': 'local',
            'elementType': 'geometry',
            'stylers': {
                'visibility': 'on',
                'weight': 1
            }
        }, {
            'featureType': 'local',
            'elementType': 'geometry.fill',
            'stylers': {
                'color': '#d8d8d8ff'
            }
        }, {
            'featureType': 'local',
            'elementType': 'geometry.stroke',
            'stylers': {
                'color': '#ffffffff'
            }
        }, {
            'featureType': 'local',
            'elementType': 'labels',
            'stylers': {
                'visibility': 'on'
            }
        }, {
            'featureType': 'local',
            'elementType': 'labels.text.fill',
            'stylers': {
                'color': '#979c9aff'
            }
        }, {
            'featureType': 'local',
            'elementType': 'labels.text.stroke',
            'stylers': {
                'color': '#ffffffff'
            }
        }, {
            'featureType': 'railway',
            'elementType': 'geometry',
            'stylers': {
                'visibility': 'on',
                'weight': 1
            }
        }, {
            'featureType': 'railway',
            'elementType': 'geometry.fill',
            'stylers': {
                'color': '#949494ff'
            }
        }, {
            'featureType': 'railway',
            'elementType': 'geometry.stroke',
            'stylers': {
                'color': '#ffffffff'
            }
        }, {
            'featureType': 'subway',
            'elementType': 'geometry',
            'stylers': {
                'visibility': 'on',
                'weight': 1
            }
        }, {
            'featureType': 'subway',
            'elementType': 'geometry.fill',
            'stylers': {
                'color': '#d8d8d8ff'
            }
        }, {
            'featureType': 'subway',
            'elementType': 'geometry.stroke',
            'stylers': {
                'color': '#ffffffff'
            }
        }, {
            'featureType': 'subway',
            'elementType': 'labels',
            'stylers': {
                'visibility': 'on'
            }
        }, {
            'featureType': 'subway',
            'elementType': 'labels.text.fill',
            'stylers': {
                'color': '#979c9aff'
            }
        }, {
            'featureType': 'subway',
            'elementType': 'labels.text.stroke',
            'stylers': {
                'color': '#ffffffff'
            }
        }, {
            'featureType': 'continent',
            'elementType': 'labels',
            'stylers': {
                'visibility': 'on'
            }
        }, {
            'featureType': 'continent',
            'elementType': 'labels.icon',
            'stylers': {
                'visibility': 'on'
            }
        }, {
            'featureType': 'continent',
            'elementType': 'labels.text.fill',
            'stylers': {
                'color': '#333333ff'
            }
        }, {
            'featureType': 'continent',
            'elementType': 'labels.text.stroke',
            'stylers': {
                'color': '#ffffffff'
            }
        }, {
            'featureType': 'city',
            'elementType': 'labels.icon',
            'stylers': {
                'visibility': 'on'
            }
        }, {
            'featureType': 'city',
            'elementType': 'labels',
            'stylers': {
                'visibility': 'on'
            }
        }, {
            'featureType': 'city',
            'elementType': 'labels.text.fill',
            'stylers': {
                'color': '#454d50ff'
            }
        }, {
            'featureType': 'city',
            'elementType': 'labels.text.stroke',
            'stylers': {
                'color': '#ffffffff'
            }
        }, {
            'featureType': 'town',
            'elementType': 'labels.icon',
            'stylers': {
                'visibility': 'on'
            }
        }, {
            'featureType': 'town',
            'elementType': 'labels',
            'stylers': {
                'visibility': 'on'
            }
        }, {
            'featureType': 'town',
            'elementType': 'labels.text.fill',
            'stylers': {
                'color': '#454d50ff'
            }
        }, {
            'featureType': 'town',
            'elementType': 'labels.text.stroke',
            'stylers': {
                'color': '#ffffffff'
            }
        }, {
            'featureType': 'road',
            'elementType': 'geometry.fill',
            'stylers': {
                'color': '#47434c8a'
            }
        }, {
            'featureType': 'road',
            'elementType': 'labels',
            'stylers': {
                'visibility': 'off'
            }
        }, {
            'featureType': 'road',
            'elementType': 'labels.text.stroke',
            'stylers': {
                'color': '#ffffff00'
            }
        }, {
            'featureType': 'poilabel',
            'elementType': 'labels',
            'stylers': {
                'visibility': 'off'
            }
        }, {
            'featureType': 'poilabel',
            'elementType': 'labels.icon',
            'stylers': {
                'visibility': 'off'
            }
        }, {
            'featureType': 'poilabel',
            'elementType': 'labels.text.stroke',
            'stylers': {
                'color': '#ffffff00'
            }
        }, {
            'featureType': 'road',
            'elementType': 'labels.text.fill',
            'stylers': {
                'color': '#8f8899ff'
            }
        }, {
            'featureType': 'districtlabel',
            'elementType': 'labels.icon',
            'stylers': {
                'visibility': 'off'
            }
        }, {
            'featureType': 'districtlabel',
            'elementType': 'labels',
            'stylers': {
                'visibility': 'on'
            }
        }, {
            'featureType': 'manmade',
            'elementType': 'geometry',
            'stylers': {
                'color': '#47434c24'
            }
        }
    ];
    map.setMapStyleV2({styleJson:d6c208f327f127aea2bce0d231b0150c});
</script>

