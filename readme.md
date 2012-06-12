This is a Grails plugin that allows you to use [Ember.js](http://emberjs.com/) based scaffolding.

## Usage

After installing the plugin run `grails generate-all <em>domain class name</em>` to install scaffolding. Currently default
scaffolding GSP templates (_create,gsp_, _edit.gsp_, _list.gsp_, _show.gsp_ and __form.gsp_) will be created alongside
the _Ember_ enabled _index.gsp_ you can delete these extra files.

## Limitations

This is an experimental work-in-progress. It is far from complete.

## To-do

- views
    - create
    - edit
    - show
- list pagination
- list sorting
- i18n
- flash messages
- use proper REST URL scheme
- supress generation of non-needed GSP templates
- support different rendering for different property types