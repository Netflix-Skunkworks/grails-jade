[![Build Status](https://travis-ci.org/ctoestreich/grails-jade.png?branch=master)](https://travis-ci.org/ctoestreich/grails-jade)

<a name="Top"></a>

GRAILS JADE PLUGIN
======

The Grails Jade plugin allows you to replace or use in conjunction [jade](http://jade-lang.com/) files with Grails views.  This plugin is a wrapper for [jade4j](https://github.com/neuland/jade4j) and [spring-jade4j](https://github.com/neuland/jade4j).  There are several working examples in the plugin source in version control that will help you get started.

CONFIGURATION
---------------

The plugin allows customization on how the jade is rendered via a few different configuration options.  Below is the default configuration that is bundled.  To change the configuration simple add the block below to your Config.grooy and change the values.  You only need to add the values you with to replace as the default config will be merged with yours.

##### JadeDefaultConfig.groovy #####

``` groovy
grails {
	plugin {
		jade {
			/* Format the HTML or compress the output by removing unecessary whitespace. */
			prettyPrint = true

			/* Store the parsed template or reparse for every request. */
			caching = true

			/* Render exceptions in view or fail silently. */
			renderExceptions = true

			/* Additional filters for embedding different content types in a template, such as markdown, coffeescript */
			filters = [:]

			/* Default objects available to all templates. */
			sharedVariables = [:]
		}
	}
}
```

### Coffeescript Filter ###

To add filtering for coffeescript you would need to add [coffeescript-jade-filter](https://github.com/neuland/jade4j-coffeescript-filter) and [jcoffeescript](https://github.com/neuland/jade4j-coffeescript-filter/tree/master/lib) to your path via lib or maven and add the following to your application.

##### BuildConfig.groovy #####

``` groovy
dependencies {
    compile('jade4j-coffeescript-filter:jade4j-coffeescript-filter:0.2.0',
            'jcoffeescript:jcoffeescript:1.1')
    ...
}
```

##### Config.groovy #####

``` groovy
import de.neuland.jade4j.filter.CoffeeScriptFilter

grails {
    plugin {
        jade {
            /* Additional filters for embedding different content types in a template, such as markdown, coffeescript */
            filters = ['coffeescript': new CoffeeScriptFilter()]
        }
    }
}
```

You can then use coffeescript in your jade.

##### somefile.jade #####

``` jade
block content
    #bodytext Empty

    :coffeescript
        updateContent = -> document.getElementById('bodytext').innerHTML = 'Not Empty'

        do updateContent
```

### Markdown Filter ###

To add filtering for markdown you would need to add [markdownj](https://github.com/myabc/markdownj) to your path via lib or maven and add the following to your application.

##### BuildConfig.groovy #####

``` groovy
dependencies {
    compile('org.markdownj:markdownj:0.3.0-1.0.2b4')
    ...
}
```

##### Config.groovy #####

``` groovy
import de.neuland.jade4j.filter.MarkdownFilter

grails {
    plugin {
        jade {
            /* Additional filters for embedding different content types in a template, such as markdown, coffeescript */
            filters = ['markdown': new MarkdownFilter()]
        }
    }
}
```

##### somefile.jade #####

``` jade
block content

    #bodytext
        :markdown
            ### Hello World ###
```

### Multiple Filters ###

You can have multiple filters by simply adding them to the filter definition map.

##### Config.groovy #####

``` groovy
import de.neuland.jade4j.filter.CoffeeScriptFilter
import de.neuland.jade4j.filter.MarkdownFilter

grails {
    plugin {
        jade {
            /* Additional filters for embedding different content types in a template, such as markdown, coffeescript */
            filters = ['coffeescript': new CoffeeScriptFilter(), 'markdown': new MarkdownFilter()]
        }
    }
}
```