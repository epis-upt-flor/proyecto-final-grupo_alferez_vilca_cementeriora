package com.example.mapsbasics2

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.Toast
import com.google.ar.core.Anchor
import com.google.ar.core.Config
import com.google.ar.core.Session
import com.google.ar.sceneform.AnchorNode
import com.google.ar.sceneform.assets.RenderableSource
import com.google.ar.sceneform.math.Vector3
import com.google.ar.sceneform.rendering.ModelRenderable
import com.google.ar.sceneform.ux.ArFragment
import com.google.ar.sceneform.ux.TransformableNode
import java.util.EnumSet


class CustomARFragment : ArFragment() {

    override fun getSessionConfiguration(session: Session?): Config {
        val config = Config(session)
        config.focusMode = Config.FocusMode.AUTO
        config.planeFindingMode = Config.PlaneFindingMode.HORIZONTAL
        return config
    }

    override fun getSessionFeatures(): MutableSet<Session.Feature> {
        return EnumSet.of(Session.Feature.SHARED_CAMERA)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val frameLayout =
            super.onCreateView(inflater, container, savedInstanceState) as FrameLayout?
        return frameLayout
    }
}


class ARCementerio : AppCompatActivity() {

    private var renderable: ModelRenderable? = null
    private lateinit var arFragment: CustomARFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_arcementerio)
        arFragment = supportFragmentManager.findFragmentById(R.id.ux_fragment) as CustomARFragment
        downloadModel("https://firebasestorage.googleapis.com/v0/b/cementeriora.appspot.com/o/flower.glb?alt=media&token=00c4d6b4-166b-404d-a075-8495b86de79d")
        arFragment.setOnTapArPlaneListener { hitResult, plane, motionEvent ->
            if(renderable==null){return@setOnTapArPlaneListener}
            val anchor: Anchor = hitResult.createAnchor()
            val anchorNode = AnchorNode(anchor)
            anchorNode.setParent(arFragment.arSceneView.scene)
            val node = TransformableNode(arFragment.transformationSystem)
            node.renderable = renderable
            node.scaleController.minScale = 0.06f
            node.scaleController.maxScale = 1.0f
            node.worldScale = Vector3(0.5f, 0.5f, 0.5f)
            node.setParent(anchorNode)
            node.select()}
    }

    private fun downloadModel(URL_ruta: String?) {
        var renderableSource = RenderableSource.builder()
            .setSource(this, Uri.parse(URL_ruta),RenderableSource.SourceType.GLB)
            .setRecenterMode(RenderableSource.RecenterMode.CENTER)
            .build()

        ModelRenderable.builder()
            .setSource(
                this,
                renderableSource
            )
            .build()
            .thenAccept{ modelRenderable ->
                renderable = modelRenderable
                val toast =
                    Toast.makeText(
                        this@ARCementerio,
                        "Descarga completa, toque una superficie",
                        Toast.LENGTH_LONG
                    )
                toast.show()
            }
            .exceptionally { throwable ->
                val toast = Toast.makeText(
                    this@ARCementerio,
                    "No se pudo descargar elemento 3d",
                    Toast.LENGTH_LONG
                )
                toast.show()
                return@exceptionally null
            }
    }


}


