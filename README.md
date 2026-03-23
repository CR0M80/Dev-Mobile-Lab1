Application Android minimaliste affichant un message Toast et un compteur interactif.


## Démonstration

> **Video Demonstrative**
<video src="demo.mp4" controls width="400"></video>

## Interface — `res/layout/activity_main.xml`

Le fichier XML décrit l'interface visuelle de l'écran principal.

### Conteneur principal — `LinearLayout`

```xml
<LinearLayout
    android:orientation="vertical"
    android:gravity="center"
    android:padding="32dp"
    android:background="#0D1117">
```

| Attribut | Valeur | Rôle |
|---|---|---|
| `orientation` | `vertical` | Empile les éléments de haut en bas |
| `gravity` | `center` | Centre tout le contenu |
| `padding` | `32dp` | Marge intérieure de 32dp |
| `background` | `#0D1117` | Fond sombre (style GitHub dark) |

### Titre — `TextView` (tv_signature)

```xml
<TextView
    android:id="@+id/tv_signature"
    android:text="Hello Toast App"
    android:textColor="#58A6FF"
    android:textSize="13sp"
    android:letterSpacing="0.15"/>
```

Simple étiquette en haut de l'écran. La couleur `#58A6FF` est un bleu clair bien lisible sur fond sombre.

### Compteur — `TextView` (tv_counter)

```xml
<TextView
    android:id="@+id/tv_counter"
    android:text="0"
    android:layout_width="120dp"
    android:layout_height="120dp"
    android:textSize="48sp"
    android:textStyle="bold"
    android:gravity="center"/>
```
### Label — `TextView` (tv_label)

```xml
<TextView
    android:id="@+id/tv_label"
    android:text="clics"
    android:textColor="#8B949E"
    android:textSize="14sp"/>
```

Texte descriptif en gris clair, placé juste sous le compteur pour indiquer l'unité.

### Bouton Toast — `Button` (btn_toast)

```xml
<Button
    android:id="@+id/btn_toast"
    android:text="Afficher Toast"
    android:backgroundTint="#238636"
    android:textColor="#FFFFFF"/>
```

Bouton vert (`#238636`) qui déclenche l'affichage du message Toast au clic.

### Bouton Incrémenter — `Button` (btn_increment)

```xml
<Button
    android:id="@+id/btn_increment"
    android:text="Incrémenter"
    android:backgroundTint="#1F6FEB"
    android:textColor="#FFFFFF"/>
```

Bouton bleu (`#1F6FEB`) qui incrémente le compteur à chaque clic.

---

## ☕ Logique — `MainActivity.java`

### Imports nécessaires

```java
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
```

| Import | Rôle |
|---|---|
| `Button` | Référencer les boutons du layout |
| `TextView` | Référencer et modifier le compteur |
| `Toast` | Afficher le message flottant temporaire |
| `AppCompatActivity` | Classe de base pour l'activité Android |

### Variable d'état

```java
private int compteur = 0;
```

Variable entière initialisée à `0`. Elle persiste tant que l'activité est en vie et est incrémentée à chaque clic sur le bouton dédié.

### `onCreate()` — point d'entrée

```java
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ...
}
```

Méthode appelée automatiquement par Android au lancement de l'activité. `setContentView` charge le layout XML défini dans `activity_main.xml`.

### Liaison des vues

```java
TextView tvCounter = findViewById(R.id.tv_counter);
Button   btnToast  = findViewById(R.id.btn_toast);
Button   btnIncr   = findViewById(R.id.btn_increment);
```

`findViewById` récupère chaque vue par son identifiant `@+id` déclaré dans le XML, et permet de les manipuler depuis le code Java.

### Bouton 1 — Afficher un Toast

```java
btnToast.setOnClickListener(v ->
    Toast.makeText(this, "Hello dear friend", Toast.LENGTH_SHORT).show()
);
```

Au clic, `Toast.makeText()` crée un message flottant avec trois paramètres : le contexte (`this`), le texte à afficher, et la durée (`LENGTH_SHORT` = ~2 secondes). `.show()` le rend visible.

### Bouton 2 — Incrémenter le compteur

```java
btnIncr.setOnClickListener(v -> {
    compteur++;
    tvCounter.setText(String.valueOf(compteur));
});
```

Au clic, `compteur` est incrémenté de 1, puis `setText()` met à jour le `TextView` avec la nouvelle valeur. `String.valueOf()` convertit l'entier en chaîne de caractères.

---
