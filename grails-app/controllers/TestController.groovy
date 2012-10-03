class TestController {
    def echo() {
        render 'here'
    }

    def index() { }

    def model() {
        session.test = 'A session message'
        [city: 'Philadelphia', team: 'Phillies']
    }

    def flash() {
        flash.message = 'This is a flash message'
        redirect(action: 'index')
    }

    def layout() {
        render view: 'layoutTest', model: [title: 'Layout Test']
    }

}